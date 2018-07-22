package com.example.king.mytemplate.di;

import android.app.Application;

import com.example.king.mytemplate.MyApplication;
import com.example.king.mytemplate.util.UserUtil;
import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
import javax.inject.Singleton;

@Singleton
@Component(modules = {ApplicationModule.class,
        ActivityBindingModule.class,
        RepositoryModule.class,
        ViewModelModule.class,
        UseCaseModule.class,
        AndroidSupportInjectionModule.class})
public interface AppComponent extends AndroidInjector<MyApplication> {

    UserUtil getUserUtil();

    // Gives us syntactic sugar. we can then do DaggerAppComponent.builder().application(this).build().inject(this);
    // never having to instantiate any modules or say which module we are passing the application to.
    // Application will just be provided into our app graph now.
    @Component.Builder
    interface Builder {

        @BindsInstance
        AppComponent.Builder application(Application application);

        AppComponent build();
    }
}
