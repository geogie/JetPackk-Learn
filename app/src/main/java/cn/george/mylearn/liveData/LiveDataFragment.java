package cn.george.mylearn.liveData;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;
import java.util.List;

import cn.george.mylearn.R;
import cn.george.mylearn.customLiveData.MyLiveData;

/**
 * Created By George
 * Description:
 * 创建Observer对象，添加观察者
 */
public class LiveDataFragment extends Fragment implements View.OnClickListener {
    private static final String TAG = "LiveDataFragment-";
    private NameViewModel mNameViewModel;

    public static LiveDataFragment getInstance() {
        return new LiveDataFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mNameViewModel = ViewModelProviders.of(this).get(NameViewModel.class);
        mNameViewModel.getmCurrentName().observe(this, (String name) -> Log.d(TAG, "name:" + name));
        mNameViewModel.getmNameListData().observe(this, (List<String> nameList) -> {
            for (String item : nameList) {
                Log.d(TAG, "list-name:" + item);
            }
        });
        MyLiveData.getInstance(getContext()).observe(this,(Integer wifiLevel)-> Log.d(TAG,"wifiLevel:"+wifiLevel));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_livedata, container, false);
        TextView tvChangeName = view.findViewById(R.id.tvChangeName);
        TextView tvChangeList = view.findViewById(R.id.tvChangeList);
        tvChangeName.setOnClickListener(this);
        tvChangeList.setOnClickListener(this);
        return view;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tvChangeName:
                Log.d(TAG, "点击-修改名字");
                mNameViewModel.getmCurrentName().setValue("Jane");
                break;
            case R.id.tvChangeList:
                Log.d(TAG, "点击-修改列表");
                List<String> nameList = new ArrayList<>();
                for (int i = 0; i < 10; i++) {
                    nameList.add("Jane<" + i + ">");
                }
                mNameViewModel.getmNameListData().setValue(nameList);
                break;

        }
    }

    @Override
    public void onPause() {
        super.onPause();

    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d(TAG, "点击-onStop-修改名字");
        mNameViewModel.getmCurrentName().setValue("Jane");
    }

    @Override
    public void onDestroy() {
        Log.d(TAG, "点击-修改名字");
        mNameViewModel.getmCurrentName().setValue("Jane");
        super.onDestroy();
        Log.d(TAG, "点击-修改名字");
        mNameViewModel.getmCurrentName().setValue("Jane");
    }
}
