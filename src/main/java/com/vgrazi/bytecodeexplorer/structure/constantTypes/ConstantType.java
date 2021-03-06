package com.vgrazi.bytecodeexplorer.structure.constantTypes;

import com.vgrazi.bytecodeexplorer.structure.ClassFileSection;
import com.vgrazi.bytecodeexplorer.structure.ConstantPoolSection;
import com.vgrazi.bytecodeexplorer.utils.Utils;

import java.util.List;

/**
 * Created by vgrazi on 11/15/15.
 */
public abstract class ConstantType implements ClassFileSection, Cloneable{


    private static List<ConstantType> constants;
    private int index;

    public abstract int length();

    public abstract int getStartByteIndex();

    public abstract byte getTag();

    public abstract void setData(byte[] bytes, int index);

    public static  void setConstants(List<ConstantType> constants) {
        ConstantType.constants = constants;
    }

    public static List<ConstantType> getConstants() {
        return ConstantPoolSection.getConstants();
    }


    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
            return null;
        }
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getIndex() {
        return this.index;
    }

    protected String getFormattedAddressAndConstantIndex() {
        return Utils.formatAsFourByteHexString(getStartByteIndex()) + " " + String.format("(#%d) ", getIndex());
    }

}
