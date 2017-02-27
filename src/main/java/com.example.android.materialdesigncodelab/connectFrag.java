package com.example.android.materialdesigncodelab;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by Varun Nagaraj on 26-02-2017.
 */
public class connectFrag extends Fragment {

    private BluetoothAdapter bluetoothAdapter = null;
    public static final int REQUEST_CONNECT = 2;
    public static final int START_CONVERSATION = 1;

//    private ChatService chatService = null;

    private String address = null;

    sendAddress activityCommander;

//    @Override
//    public void onAttach(Activity activity) {
//        super.onAttach(activity);
//        try{
//            activityCommander = (sendAddress) activity;
//        }catch (ClassCastException e){
//            throw new ClassCastException(activity.toString());
//        }
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

//
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
        View view = inflater.inflate(R.layout.connect_layout, container, false);

        final Button ScanButton = (Button) view.findViewById(R.id.ScanButton);
        final Button DiscoverableButton = (Button) view.findViewById(R.id.DiscoverableButton);

        ScanButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
//                        Toast.makeText(getActivity(), "scanButton Clicked!",
//                                Toast.LENGTH_LONG).show();
                        Intent serverIntent = null;
                        serverIntent = new Intent(getActivity(), DeviceScanActivity.class);
                        startActivityForResult(serverIntent, REQUEST_CONNECT);
                    }
                }
        );

        DiscoverableButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
//                        makeDiscOnClick(view);
                        if (bluetoothAdapter.getScanMode() != BluetoothAdapter.SCAN_MODE_CONNECTABLE_DISCOVERABLE) {
                            Intent discoverableIntent = new Intent(
                                    BluetoothAdapter.ACTION_REQUEST_DISCOVERABLE);
                            discoverableIntent.putExtra(
                                    BluetoothAdapter.EXTRA_DISCOVERABLE_DURATION, 300);
                            startActivity(discoverableIntent);
                        }
                        ((MainActivity)getActivity()).selectFragment(0);
//                        Intent serverIntent = null;
//                        serverIntent = new Intent(getActivity(), convoFrag.class);
//                        startActivityForResult(serverIntent, START_CONVERSATION);
                    }
                }
        );
        return view;
    }

    public interface sendAddress{
        public void sendAddresstoFrag(String address);
    }

    public void startChat(String address){
        Toast.makeText(getActivity(), address, Toast.LENGTH_LONG).show();
        activityCommander.sendAddresstoFrag(address);
        }
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
//            case REQUEST_CONNECT_DEVICE_SECURE:
//                if (resultCode == Activity.RESULT_OK) {
//                    connectDevice(data, true);
//                }
//                break;
            case REQUEST_CONNECT:
                if (resultCode == Activity.RESULT_OK) {
                    address = data.getExtras().getString(
                            DeviceScanActivity.DEVICE_ADDRESS);
//                    startChat(address);
                    ((MainActivity)getActivity()).selectFragment(0);
//                    connectDevice(data, false);
                }
                break;
//            case REQUEST_ENABLE_BT:
//                if (resultCode == Activity.RESULT_OK) {
//                    setupChat();
//                } else {
//                    Toast.makeText(this, R.string.bt_not_enabled_leaving,
//                            Toast.LENGTH_SHORT).show();
//                    finish();
//                }
        }
    }

//    public void print(String address){
//        Toast.makeText(getActivity(), address, Toast.LENGTH_LONG).show();
//    }
}
