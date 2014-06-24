package com.floracraftteam.floracraft2.core.handlers.network;

import io.netty.buffer.ByteBuf;


import com.floracraftteam.floracraft2.tile.TileEntityRefiningTable;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.network.simpleimpl.IMessage;
import cpw.mods.fml.common.network.simpleimpl.IMessageHandler;
import cpw.mods.fml.common.network.simpleimpl.MessageContext;

public class MessageTileEntityRefiningTable implements IMessage, IMessageHandler<MessageTileEntityRefiningTable, IMessage>
{
    public int x, y, z;
    public byte orientation;
    public byte state;
    public String customName, owner;
    public int itemId, metaData, stackSize, itemColor;

    public MessageTileEntityRefiningTable()
    {
    }

    public MessageTileEntityRefiningTable(TileEntityRefiningTable tileEntityRefiningTable, ItemStack outputItemStack)
    {
        this.x = tileEntityRefiningTable.xCoord;
        this.y = tileEntityRefiningTable.yCoord;
        this.z = tileEntityRefiningTable.zCoord;
        this.orientation = (byte) tileEntityRefiningTable.getOrientation().ordinal();
        this.state = (byte) tileEntityRefiningTable.getState();
        this.customName = tileEntityRefiningTable.getCustomName();
        this.owner = tileEntityRefiningTable.getOwner();

        if (outputItemStack != null)
        {
            this.itemId = Item.getIdFromItem(outputItemStack.getItem());
            this.metaData = outputItemStack.getItemDamage();
            this.stackSize = outputItemStack.stackSize;
        }
        else
        {
            this.itemId = -1;
            this.metaData = 0;
            this.stackSize = 0;
            this.itemColor = 0;
        }
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
        this.itemId = buf.readInt();
        this.metaData = buf.readInt();
        this.stackSize = buf.readInt();
        this.itemColor = buf.readInt();
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
        buf.writeInt(itemId);
        buf.writeInt(metaData);
        buf.writeInt(stackSize);
        buf.writeInt(itemColor);
    }

    @Override
    public IMessage onMessage(MessageTileEntityRefiningTable message, MessageContext ctx)
    {
        TileEntity tileEntity = FMLClientHandler.instance().getClient().theWorld.getTileEntity(message.x, message.y, message.z);

        if (tileEntity instanceof TileEntityRefiningTable)
        {
            ((TileEntityRefiningTable) tileEntity).setOrientation(message.orientation);
            ((TileEntityRefiningTable) tileEntity).setState(message.state);
            ((TileEntityRefiningTable) tileEntity).setCustomName(message.customName);
            ((TileEntityRefiningTable) tileEntity).setOwner(message.owner);

            ItemStack outputItemStack = null;

            if (message.itemId != -1)
            {
                outputItemStack = new ItemStack(Item.getItemById(message.itemId), message.stackSize, message.metaData);
            }

            ((TileEntityRefiningTable) tileEntity).outputItemStack = outputItemStack;


            FMLClientHandler.instance().getClient().theWorld.func_147451_t(message.x, message.y, message.z);
        }

        return null;
    }

    @Override
    public String toString()
    {
        return String.format("MessageTileEntityRefiningTable - x:%s, y:%s, z:%s, orientation:%s, state:%s, customName:%s, owner:%s, itemId: %s, metaData: %s, stackSize: %s", x, y, z, orientation, state, customName, owner, itemId, metaData, stackSize);
    }
}