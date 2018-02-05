package www.doloop.com.mvp_demo_frame;

import java.lang.ref.WeakReference;

/**
 * Created by ZHAO_NAN on 2018/1/10.
 */

public abstract class BasePresenter<V extends BaseViewInter, M extends BaseModelInter> {
    private WeakReference<V> weakReference;
    protected M model;
    public void attach(V t) {
        weakReference = new WeakReference<>(t);
        if(model == null) {
            model = getModel();
        }
    }

    public void deAttach() {
        if (weakReference != null) {
            weakReference.clear();
            weakReference = null;
        }
    }

    public boolean isViewAttached() {
        return weakReference != null && weakReference.get() != null;
    }

    public V getView() {
        if (weakReference != null) {
            return weakReference.get();
        }
        return null;
    }
    protected abstract M getModel();
}