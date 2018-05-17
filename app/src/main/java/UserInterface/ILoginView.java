package UserInterface;

import com.vaadin.ui.Button;

public interface ILoginView {

    interface LoginListener {
        void buttonClick(String buttonTitle);

    }
    public void addListener(LoginListener listener);


}

