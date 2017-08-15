package viquar.com.basictabbedfragment;


import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;


public class TAB1 extends Fragment {

    private ImageView downloadedImg;
    private ProgressDialog simpleWaitDialog;
    Button imageDownloaderBtn;
    View rootView;
    TextView show;
    private String downloadUrl = "https://static.pexels.com/photos/170811/pexels-photo-170811.jpeg";
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        rootView= inflater.inflate(R.layout.fragment_tab1, container, false);
        imageDownloaderBtn = (Button) rootView.findViewById(R.id.downloadButton);

        downloadedImg = (ImageView) rootView.findViewById(R.id.imageView);
        show= (TextView) rootView.findViewById(R.id.textViewShow);

        imageDownloaderBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                new ImageDownloader().execute(downloadUrl);

            }

        });
        return rootView;
    }

   public void receive(String s)
   {

       show.setText(s);
   }


    private class ImageDownloader extends AsyncTask<String,Integer,Bitmap> {

        private ProgressDialog mDialog;

        @Override
        protected Bitmap doInBackground(String[] params) {
            Log.d("doInBackground", "starting download of image");
            try {
                URL url = new URL(params[0]);
                HttpURLConnection connection = (HttpURLConnection)url.openConnection();
                connection.setDoInput(true);
                connection.connect();
                InputStream inputStream = connection.getInputStream();
                Bitmap myBitmap = BitmapFactory.decodeStream(inputStream);

                return  myBitmap;
            }catch (Exception e){
                e.printStackTrace();
                return null;
            }

        }

        protected void onPreExecute() {
            downloadedImg.setImageBitmap(null);
            mDialog=new ProgressDialog(getContext());
            mDialog.setMessage("Loading...");
            mDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
            mDialog.setCancelable(true);

            mDialog.show();




        }



        protected void onPostExecute(Bitmap result) {
            if (result != null) {

                downloadedImg.setImageBitmap(result);
            }
            else {
                Toast.makeText(getContext(), "no image", Toast.LENGTH_SHORT).show();
            }

            mDialog.dismiss();
        }


}

}
