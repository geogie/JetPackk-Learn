package cn.george.mylearn.liveData;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

/**
 * Created By George
 * Description:
 * 在ViewModel创建LiveData
 * 必须是 publish 否则访问受限制，crash
 */
public class NameViewModel extends ViewModel {
    private MutableLiveData<String> mCurrentName;
    private MutableLiveData<List<String>> mNameListData;

    MutableLiveData<String> getmCurrentName() {
        if (mCurrentName==null){
            mCurrentName = new MutableLiveData<>();
        }
        return mCurrentName;
    }

    MutableLiveData<List<String>> getmNameListData() {
        if (mNameListData == null){
            mNameListData = new MutableLiveData<>();
        }
        return mNameListData;
    }
}
