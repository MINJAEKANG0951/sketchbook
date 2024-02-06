package minjaelab.sketchbook.app1.fragment.viewmodel_and_livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StorageViewModel extends ViewModel
{
    private MutableLiveData<Integer> tiktok        = new MutableLiveData<>();
    private MutableLiveData<String> data           = new MutableLiveData<>();


    public void setTime(Integer newTime)    { this.tiktok.setValue(newTime); }
    public void setData(String newData)     { this.data.setValue(newData);}


    public LiveData <Integer> getTime()      { return this.tiktok; }
    public LiveData <String> getData()       { return this.data; }


}
