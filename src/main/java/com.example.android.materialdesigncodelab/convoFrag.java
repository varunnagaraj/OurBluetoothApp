package com.example.android.materialdesigncodelab;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Varun Nagaraj on 26-02-2017.
 */
public class convoFrag extends Fragment{

//    private ListView lvMainChat;
//    private EditText etMain;
//    private Button btnSend;
//
//    private ChatService chatService = null;
//    private StringBuffer outStringBuffer;
//
//    public static final int MESSAGE_STATE_CHANGE = 1;
//    public static final int MESSAGE_READ = 2;
//    public static final int MESSAGE_WRITE = 3;
//    public static final int MESSAGE_DEVICE_NAME = 4;
//    public static final int MESSAGE_TOAST = 5;
//
//    private static final int REQUEST_CONNECT_DEVICE_SECURE = 1;
//    private static final int REQUEST_CONNECT_DEVICE_INSECURE = 2;
//
//    public static final String DEVICE_NAME = "device_name";
//    public static final String TOAST = "toast";
//
//    private String connectedDeviceName = null;
//    private ArrayAdapter<String> chatArrayAdapter;

//    private Handler handler = new Handler(new Handler.Callback() {
//
//        @Override
//        public boolean handleMessage(Message msg) {
//            switch (msg.what) {
//                case MESSAGE_STATE_CHANGE:
//                    switch (msg.arg1) {
//                        case ChatService.STATE_CONNECTED:
////                            setStatus(getString(R.string.title_connected_to,
////                                    connectedDeviceName));
//                            chatArrayAdapter.clear();
//                            break;
//                        case ChatService.STATE_CONNECTING:
////                            setStatus(R.string.title_connecting);
//                            break;
//                        case ChatService.STATE_LISTEN:
//                        case ChatService.STATE_NONE:
////                            setStatus(R.string.title_not_connected);
//                            break;
//                    }
//                    break;
//                case MESSAGE_WRITE:
//                    byte[] writeBuf = (byte[]) msg.obj;
//
//                    String writeMessage = new String(writeBuf);
//                    chatArrayAdapter.add("Me:  " + writeMessage);
//                    break;
//                case MESSAGE_READ:
//                    byte[] readBuf = (byte[]) msg.obj;
//
//                    String readMessage = new String(readBuf, 0, msg.arg1);
//                    chatArrayAdapter.add(connectedDeviceName + ":  " + readMessage);
//                    break;
//                case MESSAGE_DEVICE_NAME:
//
//                    connectedDeviceName = msg.getData().getString(DEVICE_NAME);
////                    Toast.makeText(getApplicationContext(),
////                            "Connected to " + connectedDeviceName,
////                            Toast.LENGTH_SHORT).show();
//                    break;
//                case MESSAGE_TOAST:
////                    Toast.makeText(getApplicationContext(),
////                            msg.getData().getString(TOAST), Toast.LENGTH_SHORT)
////                            .show();
//                    break;
//            }
//            return false;
//        }
//    });

//    private final void setStatus(int resId) {
//        final ActionBar actionBar = getSupportActionBar();
//        actionBar.setSubtitle(resId);
//    }
//
//    private final void setStatus(CharSequence subTitle) {
//        final ActionBar actionBar = getSupportActionBar();
//        actionBar.setSubtitle(subTitle);
//    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
//        RecyclerView recyclerView = (RecyclerView) inflater.inflate(
//                R.layout.recycler_view, container, false);
//        ContentAdapter adapter = new ContentAdapter();
//        recyclerView.setAdapter(adapter);
//        recyclerView.setHasFixedSize(true);
        View view = inflater.inflate(R.layout.convo_layout, container, false);
//        lvMainChat = (ListView) getView().findViewById(R.id.lvMainChat);
//        etMain = (EditText) getView().findViewById(R.id.etMain);
//        btnSend = (Button) getView().findViewById(R.id.btnSend);

       // bindEventHandler();

//        return recyclerView;
        return view;
    }

//    private void bindEventHandler() {
//        etMain.setOnEditorActionListener(mWriteListener);
//
//        btnSend.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                String message = etMain.getText().toString();
//                sendMessage(message);
//            }
//        });
//    }
//    private TextView.OnEditorActionListener mWriteListener = new TextView.OnEditorActionListener() {
//        public boolean onEditorAction(TextView view, int actionId,
//                                      KeyEvent event) {
//            if (actionId == EditorInfo.IME_NULL
//                    && event.getAction() == KeyEvent.ACTION_UP) {
//                String message = view.getText().toString();
//                sendMessage(message);
//            }
//            return true;
//        }
//    };
//
//
//    private void sendMessage(String message) {
////        if (chatService.getState() != ChatService.STATE_CONNECTED) {
////            Toast.makeText(this, R.string., Toast.LENGTH_SHORT)
////                    .show();
////            return;
////        }
//
//        if (message.length() > 0) {
//            byte[] send = message.getBytes();
//            chatService.write(send);
//
//            outStringBuffer.setLength(0);
//            etMain.setText(outStringBuffer);
//        }
//    }

//    public static class ViewHolder extends RecyclerView.ViewHolder {
//        public ViewHolder(LayoutInflater inflater, ViewGroup parent) {
//            super(inflater.inflate(R.layout.convo_layout, parent, false));
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

//    @Override
//    public synchronized void onResume() {
//        super.onResume();
//
//        if (chatService != null) {
//            if (chatService.getState() == ChatService.STATE_NONE) {
//                chatService.start();
//            }
//        }
//    }


}
