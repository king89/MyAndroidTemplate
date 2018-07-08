package com.example.king.mytemplate.di;

import com.example.king.mytemplate.util.UserUtil;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * This is a Dagger module. We use this to bind our Application class as a Context in the AppComponent
 * By using Dagger Android we do not need to pass our Application instance to any module,
 * we simply need to expose our Application as Context.
 * One of the advantages of Dagger.Android is that your
 * Application & Activities are provided into your graph for you.
 * {@link
 * AppComponent}.
 */
@Module
public class ApplicationModule {
    //expose Application as an injectable context
    //@Binds
    //abstract Context bindContext(Application application);

    @Singleton
    @Provides
    static UserUtil provideUserUtil() {
        return new UserUtil();
    }

}


