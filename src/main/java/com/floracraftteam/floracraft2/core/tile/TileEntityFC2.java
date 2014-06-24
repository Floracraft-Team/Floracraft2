package com.floracraftteam.floracraft2.core.tile;

import com.floracraftteam.floracraft2.core.handlers.PacketHandler;
import com.floracraftteam.floracraft2.core.handlers.network.MessageTileEntityFC2;
import com.floracraftteam.floracraft2.core.reference.FC2Reference;

import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.network.Packet;
import net.minecraft.tileentity.TileEntity;
import net.minecraftforge.common.util.ForgeDirection;

public class TileEntityFC2 extends TileEntity
{
    protected ForgeDirection orientation;
    protected byte state;
    protected String customName;
    protected String owner;

    public TileEntityFC2()
    {
        orientation = ForgeDirection.SOUTH;
        state = 0;
        customName = "";
        owner = "";
    }

    public ForgeDirection getOrientation()
    {
        return orientation;
    }

    public void setOrientation(ForgeDirection orientation)
    {
        this.orientation = orientation;
    }

    public void setOrientation(int orientation)
    {
        this.orientation = ForgeDirection.getOrientation(orientation);
    }

    public short getState()
    {
        return state;
    }

    public void setState(byte state)
    {
        this.state = state;
    }

    public boolean hasCustomName()
    {
        return customName != null && customName.length() > 0;
    }

    public String getCustomName()
    {
        return customName;
    }

    public void setCustomName(String customName)
    {
        this.customName = customName;
    }

    public boolean hasOwner()
    {
        return owner != null && owner.length() > 0;
    }

    public String getOwner()
    {
        return owner;
    }

    public void setOwner(String owner)
    {
        this.owner = owner;
    }

    @Override
    public void readFromNBT(NBTTagCompound nbtTagCompound)
    {
        super.readFromNBT(nbtTagCompound);

        if (nbtTagCompound.hasKey(FC2Reference.DIRECTION))
        {
            this.orientation = ForgeDirection.getOrientation(nbtTagCompound.getByte(FC2Reference.DIRECTION));
        }

        if (nbtTagCompound.hasKey(FC2Reference.STATE))
        {
            this.state = nbtTagCompound.getByte(FC2Reference.STATE);
        }

        if (nbtTagCompound.hasKey(FC2Reference.CUSTOM_NAME))
        {
            this.customName = nbtTagCompound.getString(FC2Reference.CUSTOM_NAME);
        }

        if (nbtTagCompound.hasKey(FC2Reference.OWNER))
        {
            this.owner = nbtTagCompound.getString(FC2Reference.OWNER);
        }
    }

    @Override
    public void writeToNBT(NBTTagCompound nbtTagCompound)
    {
        super.writeToNBT(nbtTagCompound);

        nbtTagCompound.setByte(FC2Reference.DIRECTION, (byte) orientation.ordinal());
        nbtTagCompound.setByte(FC2Reference.STATE, state);

        if (this.hasCustomName())
        {
            nbtTagCompound.setString(FC2Reference.CUSTOM_NAME, customName);
        }

        if (this.hasOwner())
        {
            nbtTagCompound.setString(FC2Reference.OWNER, owner);
        }
    }

    @Override
    public Packet getDescriptionPacket()
    {
        return PacketHandler.INSTANCE.getPacketFrom(new MessageTileEntityFC2(this));
    }
}