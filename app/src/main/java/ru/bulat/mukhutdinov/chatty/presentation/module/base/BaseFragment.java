package ru.bulat.mukhutdinov.chatty.presentation.module.base;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public abstract class BaseFragment<Presenter extends BasePresenter> extends Fragment implements BaseView {

//    protected Presenter presenter;

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        injectPresenter();

        getPresenter().setView(this);
        getPresenter().setRouter(getActivity());

        getPresenter().onActivityCreated();
    }

    @Override
    public void onDestroyView() {
        getPresenter().onDestroyView();
        super.onDestroyView();
    }

    public abstract Presenter getPresenter();
}