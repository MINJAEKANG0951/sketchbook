package minjaelab.sketchbook.app1.fragment.callbackinterface;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public abstract class BlueprintFragmentForCallBackInterface extends Fragment
{
    protected FragmentCommunicationInterface communicationCallback;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        try
        {
            communicationCallback = (FragmentCommunicationInterface) context;
        }
        catch (ClassCastException e)
        {
            throw new ClassCastException(context.toString() + " must implement FragmentCommunicationInterface");
        }
    }


}
