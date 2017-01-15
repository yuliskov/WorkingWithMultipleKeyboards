package org.samples.keyboardmanager.addons;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

public interface AddOn {
    interface AddOnResourceMapping {
        /*@AttrRes
        int getLocalAttrIdFromRemote(@AttrRes int remoteAttributeResourceId);*/

        int[] getRemoteStyleableArrayFromLocal(int[] localStyleableArray);
    }

    int INVALID_RES_ID = 0;

    String getId();

    String getName();

    String getDescription();

    String getPackageName();

    @Nullable
    Context getPackageContext();

    int getSortIndex();

    @NonNull
    AddOnResourceMapping getResourceMapping();
}
