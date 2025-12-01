package uas.views;

import java.util.Comparator;
import java.util.List;

import uas.controllers.DeviceControllers;
import uas.models.Device;
import uas.models.Fedora;
import uas.models.Ubuntu;
import uas.models.Windows;
import uas.models.exception.EmptyListException;
import uas.models.exception.InvalidInputMenuException;
import uas.util.CLIUtil;

public class DeviceView {
    private DeviceControllers deviceControllers;

    public DeviceView() {
        this.deviceControllers = new DeviceControllers();
    }

    public void render() {
        int menu = -1;
        while (menu != 0) {
            try {
                this.printMenu();
                menu = CLIUtil.getInt();
                if (menu < 0 || menu > 3) {
                    throw new InvalidInputMenuException("Salah menu: " + menu);
                }
                switch (menu) {
                    case 1:
                        this.handleTambahDevice();
                        break;
                    case 2:
                        this.handlePrintDevice();
                        break;
                    case 3:
                        this.renderListView(true);
                        break;
                    case 0:
                        return;
                }
                this.printMenu();
                menu = CLIUtil.getInt();
            } catch (InvalidInputMenuException e) {
                System.out.println(e.getMessage());
            } catch (EmptyListException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printMenu() {
        System.out.println("Menu:");
        System.out.println("1. Tambah device");
        System.out.println("2. Tampilkan semua device");
        System.out.println("3. Tampilkan semua device terurut berdasarkan OS");
        System.out.println("0. Keluar");
    }

    private void handleTambahDevice() throws InvalidInputMenuException {
        int os = 0;
        String ownerName = "";
        String version = "";
        CLIUtil.getString();
        ownerName = CLIUtil.askForString("Masukkan nama pengguna: ");
        os = CLIUtil.askForInt("Pilih OS: 1. Windows, 2. Ubuntu, 3. Fedora ");
        if (os < 1 || os > 3) {
            throw new InvalidInputMenuException("Salah pilihan operating system: " + os);
        }
        CLIUtil.getString();
        version = CLIUtil.askForString("Masukkan versi");
        switch (os) {
            case 1:
                deviceControllers.addDevice(ownerName, new Windows(version));
                break;
            case 2:
                deviceControllers.addDevice(ownerName, new Ubuntu(version));
                break;
            case 3:
                deviceControllers.addDevice(ownerName, new Fedora(version));
                break;
        }
    }

    private void handlePrintDevice() throws EmptyListException {
        if (deviceControllers.getDeviceInfo().isEmpty()) {
            throw new EmptyListException("Daftar device kosong");
        }
        for (Device device : deviceControllers.getDeviceInfo()) {
            System.out.println(device.getDetails());
        }
    }

    class DeviceComparator implements Comparator<Device> {
        boolean isAscending;

        public DeviceComparator() {
            this(true);
        }

        public DeviceComparator(boolean isAscending) {
            this.isAscending = isAscending;
        }

        @Override
        public int compare(Device o1, Device o2) {
            return o1.getOperatingSystem().getName().compareTo(o2.getOperatingSystem().getName());
        }
    }

    public void renderListView(boolean sortedByVolumeAscending) {
        var objects = deviceControllers.getDeviceInfo();
        objects.sort(new DeviceComparator(sortedByVolumeAscending));
        renderListView(objects);
    }

    private void renderListView(List<Device> objects) {
        for (int i = 0; i < objects.size(); i++) {
            Device object = objects.get(i);
            System.out.println(object.getDetails());
        }
    }
}
