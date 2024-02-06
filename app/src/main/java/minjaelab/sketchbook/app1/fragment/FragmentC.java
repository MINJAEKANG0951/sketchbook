package minjaelab.sketchbook.app1.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import minjaelab.sketchbook.R;
import minjaelab.sketchbook.app1.fragment.callbackinterface.BlueprintFragmentForCallBackInterface;

public class FragmentC extends BlueprintFragmentForCallBackInterface
{
    private Button callBackInterfaceSend;
    private Button viewModelSend;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_c, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        connectViews(view);
        addListenersToTheViews();
    }

    private void connectViews(View view) {
        callBackInterfaceSend   = view.findViewById(R.id.callBackInterfaceSend);
        viewModelSend           = view.findViewById(R.id.viewModelSend);
    }

    private void addListenersToTheViews() {
        callBackInterfaceSend.setOnClickListener(view -> {
            communicationCallback.onFragmentInteraction("C");
        });
        viewModelSend.setOnClickListener(view -> {

        });
    }
}