/*
 * Copyright (C) 2010 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.internal.statusbar;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @hide
 */
public class StatusBarIcon implements Parcelable {
    public String iconPackage;
    public int iconId;
    public int iconLevel;

    private StatusBarIcon() {
    }

    public StatusBarIcon(String iconPackage, int iconId, int iconLevel) {
        this.iconPackage = iconPackage;
        this.iconId = iconId;
        this.iconLevel = iconLevel;
    }

    public StatusBarIcon clone() {
        return new StatusBarIcon(this.iconPackage, this.iconId, this.iconLevel);
    }

    /**
     * Unflatten the StatusBarIcon from a parcel.
     */
    public StatusBarIcon(Parcel in) {
        readFromParcel(in);
    }

    public void readFromParcel(Parcel in) {
        this.iconPackage = in.readString();
        this.iconId = in.readInt();
        this.iconLevel = in.readInt();
    }

    public void writeToParcel(Parcel out, int flags) {
        out.writeString(this.iconPackage);
        out.writeInt(this.iconId);
        out.writeInt(this.iconLevel);
    }

    public int describeContents() {
        return 0;
    }

    /**
     * Parcelable.Creator that instantiates StatusBarIcon objects
     */
    public static final Parcelable.Creator<StatusBarIcon> CREATOR
            = new Parcelable.Creator<StatusBarIcon>()
    {
        public StatusBarIcon createFromParcel(Parcel parcel)
        {
            return new StatusBarIcon(parcel);
        }

        public StatusBarIcon[] newArray(int size)
        {
            return new StatusBarIcon[size];
        }
    };
}

