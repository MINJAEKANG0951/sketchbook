package minjaelab.sketchbook.app1.fragment;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public abstract class BlueprintFragment extends Fragment
{
    protected FragmentCommunicationInterface communicationCallback;
    public interface FragmentCommunicationInterface {
        void onFragmentInteraction(String data);
    }

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
