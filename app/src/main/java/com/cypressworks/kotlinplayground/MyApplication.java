package com.cypressworks.kotlinplayground;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

public class MyApplication extends Application {

    @Singleton
    @dagger.Component(modules = {AppModule.class})
    public interface AppComponent {
        void inject(MainActivity mainActivity);
    }

    @Module
    static class AppModule {
        private Context context;

        public AppModule(final Context context) {
            this.context = context.getApplicationContext();
        }

        @Provides
        Context provideContext() {
            return context;
        }
    }

    public static AppComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerMyApplication_AppComponent.builder() //
                .appModule(new AppModule(this)) //
                .build();
    }
}
