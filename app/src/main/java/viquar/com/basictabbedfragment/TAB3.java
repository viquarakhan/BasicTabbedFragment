package viquar.com.basictabbedfragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class TAB3 extends Fragment {
    WebView webv1;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView=inflater.inflate(R.layout.fragment_tab3, container, false);
        webv1=(WebView) rootView.findViewById(R.id.wv1);

        webv1.loadUrl("file:///android_res/raw/myfile.html");

        // Enable Javascript
        WebSettings webSettings = webv1.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webv1.addJavascriptInterface(new Object()
        {
            @JavascriptInterface           // For API 17+
            public void performClick(String strl)
            {

                Toast.makeText (getContext(), strl, Toast.LENGTH_SHORT).show();
            }
        }, "ok");
        // Force links and redirects to open in the WebView instead of in a browser
        webv1.setWebViewClient(new WebViewClient());
        return rootView;
    }

}
