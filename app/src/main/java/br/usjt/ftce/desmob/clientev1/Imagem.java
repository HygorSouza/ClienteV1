package br.usjt.ftce.desmob.clientev1;

import android.app.Activity;
import android.graphics.drawable.Drawable;

import java.lang.reflect.Field;

/**
 * Created by Hygor on 09/04/2017.
 */

public class Imagem {

    public static Drawable getDrawable(Activity context, String drawableName){
        //procurar a imagem usando Reflection
        Class<?> c = R.drawable.class;

        try {
            Field idField = c.getDeclaredField(drawableName);

            int id = idField.getInt(idField);
            return context.getResources().getDrawable(id,null);

        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Drawable getDrawable(Activity context){
        String drawableName = "padrao";
        return getDrawable(context,drawableName);
    }

}
