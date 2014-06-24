package com.floracraftteam.floracraft2.core.handlers.network;

import com.floracraftteam.floracraft2.core.tile.TileEntityFC2;

import net.minecraft.tileentity.TileEntity;
import io.netty.buffer.ByteBuf;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageTileEntityFC2 implements IMessage, IMessageHandler<MessageTileEntityFC2, IMessage>
{
    public int x, y, z;
    public byte orientation, state;
    public String customName, owner;

    public MessageTileEntityFC2()
    {
    }

    public MessageTileEntityFC2(TileEntityFC2 tileEntityFC2)
    {
        this.x = tileEntityFC2.xCoord;
        this.y = tileEntityFC2.yCoord;
        this.z = tileEntityFC2.zCoord;
        this.orientation = (byte) tileEntityFC2.getOrientation().ordinal();
        this.state = (byte) tileEntityFC2.getState();
        this.customName = tileEntityFC2.getCustomName();
        this.owner = tileEntityFC2.getOwner();
    }

    @Override
    public void fromBytes(ByteBuf buf)
    {
        this.x = buf.readInt();
        this.y = buf.readInt();
        this.z = buf.readInt();
        this.orientation = buf.readByte();
        this.state = buf.readByte();
        int customNameLength = buf.readInt();
        this.customName = new String(buf.readBytes(customNameLength).array());
        int ownerLength = buf.readInt();
        this.owner = new String(buf.readBytes(ownerLength).array());
    }

    @Override
    public void toBytes(ByteBuf buf)
    {
        buf.writeInt(x);
        buf.writeInt(y);
        buf.writeInt(z);
        buf.writeByte(orientation);
        buf.writeByte(state);
        buf.writeInt(customName.length());
        buf.writeBytes(customName.getBytes());
        buf.writeInt(owner.length());
        buf.writeBytes(owner.getBytes());
    }

    @Override
    public IMessage onMessage(MessageTileEntityFC2 message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntityFC2)
        {
            ((TileEntityFC2) tileEntity).setOrientation(message.orientation);
            ((TileEntityFC2) tileEntity).setState(message.state);
            ((TileEntityFC2) tileEntity).setCustomName(message.customName);
            ((TileEntityFC2) tileEntity).setOwner(message.owner);
        }

        return null;
    }

    @Override
    public String toString()
    {
        return String.format("MessageTileEntityFC2 - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s", x, y, z, orientation, state, customName, owner);
    }
}