package com.example.androidacademy.ui.main_screen;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.androidacademy.R;
import com.example.androidacademy.ui.base.BaseActivity;

import static android.content.Intent.ACTION_SEND;
import static android.content.Intent.ACTION_VIEW;
import static android.text.TextUtils.isEmpty;
import static com.example.androidacademy.utils.SocialUrl.FACEBOOK;
import static com.example.androidacademy.utils.SocialUrl.GITHUB;
import static com.example.androidacademy.utils.SocialUrl.VK;

public class MainActivity extends BaseActivity {

    private ImageView githubIcon;
    private ImageView fbIcon;
    private ImageView vkIcon;
    private EditText messageEditText;
    private LinearLayout infoContentBlock;
    private View sendMessageBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        githubIcon = findViewById(R.id.ic_github);
        fbIcon = findViewById(R.id.ic_facebook);
        vkIcon = findViewById(R.id.ic_vk);
        messageEditText = findViewById(R.id.messageEditText);
        sendMessageBtn = findViewById(R.id.send_message_btn);
        infoContentBlock = findViewById(R.id.info_content_block);
        setupListeners();
        addDisclaimer();
    }

    private void setupListeners() {
        githubIcon.setOnClickListener(iconsClickListener);
        fbIcon.setOnClickListener(iconsClickListener);
        vkIcon.setOnClickListener(iconsClickListener);
        sendMessageBtn.setOnClickListener(emailClickListener);
    }

    private void addDisclaimer() {
        TextView textView = (TextView) getLayoutInflater().inflate(R.layout.disclamer_view, null, false);
        textView.setGravity(Gravity.CENTER_HORIZONTAL);
        textView.setText(R.string.disclaimer);
        infoContentBlock.addView(textView);
    }

    private OnClickListener iconsClickListener = v -> {
        switch (v.getId()) {
            case R.id.ic_github:
                openSocialNetwork(GITHUB);
                break;
            case R.id.ic_facebook:
                openSocialNetwork(FACEBOOK);
                break;
            case R.id.ic_vk:
                openSocialNetwork(VK);
                break;
        }
    };

    private OnClickListener emailClickListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            if (isEmpty(messageEditText.getText()))
                showToast(R.string.empty_message);
            else
                sendMessage();
        }
    };

    private void sendMessage() {
        String message = messageEditText.getText().toString();
        Intent intent = new Intent(ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (isImplicitIntentSave(intent))
            startActivity(intent);
        else
            showToast(R.string.app_not_found);

    }

    private void openSocialNetwork(final String url) {
        startActivity(new Intent(ACTION_VIEW, Uri.parse(url)));
    }

}
