package uno.tau0.dedede.view;

import org.springframework.context.ApplicationContext;

public class ViewManager {
    View currentView;
    Model model;
    ApplicationContext applicationContext;

    public ViewManager(Model model, ApplicationContext applicationContext) {
        this.model = model;
        this.applicationContext = applicationContext;
    }

    public <T> T getBean(Class<T> beanClass) {
        return applicationContext.getBean(beanClass);
    }

    public void switchView(View view) {
        currentView = view;
        view.run(model, this);
    }
}
