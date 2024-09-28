//package com.tradingbot.versbot;
//
//import android.content.Context;
//import android.util.Log;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//import android.widget.TextView;
//
//import java.text.SimpleDateFormat;
//import java.util.Date;
//import java.util.List;
//import java.util.Locale;
//
//public class AccountAdapter extends BaseAdapter {
//
//    private static final String TAG = "AccountAdapter";
//    private final Context context;
//    private final List<Account> accounts;
//
//    public AccountAdapter(Context context, List<Account> accounts) {
//        this.context = context;
//        this.accounts = accounts;
//    }
//
//    @Override
//    public int getCount() {
//        return accounts.size();
//    }
//
//    @Override
//    public Object getItem(int position) {
//        return accounts.get(position);
//    }
//
//    @Override
//    public long getItemId(int position) {
//        return position;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        if (convertView == null) {
//            convertView = LayoutInflater.from(context).inflate(R.layout.list_item_account, parent, false);
//        }
//
//        TextView accountAliasTextView = convertView.findViewById(R.id.accountAlias);
//        TextView accountIdTextView = convertView.findViewById(R.id.accountId);
//        TextView botStatusTextView = convertView.findViewById(R.id.botStatus);
//
//        Account account = accounts.get(position);
//        accountAliasTextView.setText(account.getAlias());
//        accountIdTextView.setText(account.getId());
//        botStatusTextView.setText(account.getStatus());
//
//        log("Binding account to view: " + account);
//
//        return convertView;
//    }
//
//    private void log(String message) {
//        String timestamp = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS", Locale.getDefault()).format(new Date());
//        Log.d(TAG, timestamp + " - " + message);
//    }
//}
