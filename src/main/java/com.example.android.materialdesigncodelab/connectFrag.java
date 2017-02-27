package com.example.android.materialdesigncodelab;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
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
    public static final int REQUEST_CONNECT = 1;
    public static final int START_CONVERSATION = 1;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
//                R.layout.recycler_view, container, false);
//        ContentAdapter adapter = new ContentAdapter();
//        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
//
        bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
//        return recyclerView;
        View view = inflater.inflate(R.layout.connect_layout, container, false);

        final Button ScanButton = (Button) view.findViewById(R.id.ScanButton);
        final Button DiscoverableButton = (Button) view.findViewById(R.id.DiscoverableButton);

        ScanButton.setOnClickListener(
                new View.OnClickListener(){
                    public void onClick(View view){
//                        Toast.makeText(getActivity(), "scanButton Clicked!",
//                                Toast.LENGTH_LONG).show();
                        Intent serverIntent = null;
                        serverIntent = new Intent(getActivity(), DeviceListActivity.class);
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

    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        switch (requestCode) {
//            case REQUEST_CONNECT_DEVICE_SECURE:
//                if (resultCode == Activity.RESULT_OK) {
//                    connectDevice(data, true);
//                }
//                break;
            case REQUEST_CONNECT:
                if (resultCode == Activity.RESULT_OK) {
                    connectDevice(data, false);
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

    private void connectDevice(Intent data, boolean secure) {
        String address = data.getExtras().getString(
                DeviceListActivity.DEVICE_ADDRESS);
        BluetoothDevice device = bluetoothAdapter.getRemoteDevice(address);
//        chatService.connect(device, secure);
    }


//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
//            super(inflater.inflate(R.layout.connect_layout, parent, false));
//        }
//    }
//
//    public static class ContentAdapter extends RecyclerView.Adapter<ViewHolder> {
//        // Set numbers of List in RecyclerView.
//        private static final int LENGTH = 18;
//
//        public ContentAdapter() {
//        }
//
//        @Override
//        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
//            return new ViewHolder(LayoutInflater.from(parent.getContext()), parent);
//        }
//
//        @Override
//        public void onBindViewHolder(ViewHolder holder, int position) {
//            // no-op
//        }
//
//        @Override
//        public int getItemCount() {
//            return LENGTH;
//        }
//    }
}
