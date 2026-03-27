package com.yuanchuanshengjiao.voiceteach.bluetooth;

import android.bluetooth.BluetoothDevice;

public interface BluetoothConnectionListener {
    void onDeviceConnected(BluetoothDevice device);
    void onDeviceDisconnected(BluetoothDevice device);
}
