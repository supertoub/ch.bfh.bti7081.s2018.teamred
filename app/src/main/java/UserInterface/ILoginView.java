package UserInterface;


public interface ILoginView {

    interface LoginListener {
        void buttonClick(String buttonTitle);

    }

    void addListener(LoginListener listener);


}

