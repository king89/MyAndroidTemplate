package com.example.king.mytemplate.di;

import android.app.Application;
import android.content.Context;
import com.example.king.mytemplate.domain.data.ItemDataSource;
import com.example.king.mytemplate.domain.data.Local;
import com.example.king.mytemplate.domain.data.Remote;
import com.example.king.mytemplate.domain.repository.ItemRepository;
import com.example.king.mytemplate.domain.repository.ItemRepositoryImpl;
import com.example.king.mytemplate.util.UserUtil;
import dagger.Binds;
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
abstract public class ApplicationModule {
    //expose Application as an injectable context
    @Binds
    abstract Context bindContext(Application application);

    @Singleton
    @Provides
    static UserUtil provideUserUtil() {
        return new UserUtil();
    }

    @Singleton
    @Provides
    static ItemRepository provideItemRepsitory(@Local ItemDataSource local,
            @Remote ItemDataSource remote) {
        return new ItemRepositoryImpl(local, remote);
    }
}


