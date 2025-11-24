package dev.neovoxel.neobot.bot.types;

import dev.neovoxel.nbapi.event.message.GroupMessageEvent;
import dev.neovoxel.nbapi.event.message.GroupMessageType;
import dev.neovoxel.nbapi.event.message.MessageType;
import org.graalvm.polyglot.HostAccess;
import org.jetbrains.annotations.Nullable;
import org.json.JSONArray;

public class NGroupMessageEvent extends GroupMessageEvent {
    public NGroupMessageEvent(long time, long selfId, int messageId, long senderId, JSONArray message, String rawMessage, GroupMessageType subType, long groupId, long anonymousId, @org.jetbrains.annotations.Nullable String anonymousName) {
        super(time, selfId, messageId, senderId, message, rawMessage, subType, groupId, anonymousId, anonymousName);
    }

    public NGroupMessageEvent(GroupMessageEvent event) {
        super(event.getTime(), event.getSelfId(), event.getMessageId(), event.getSenderId(), event.getMessage(), event.getRawMessage(), event.getSubType(), event.getGroupId(), event.getAnonymousId(), event.getAnonymousName());
    }

    @HostAccess.Export
    public String getJsonMessage() {
        return getMessage().toString();
    }

    @HostAccess.Export
    @Override
    public int getMessageId() {
        return super.getMessageId();
    }

    @HostAccess.Export
    @Override
    public GroupMessageType getSubType() {
        return super.getSubType();
    }

    @HostAccess.Export
    @Override
    public long getGroupId() {
        return super.getGroupId();
    }

    @HostAccess.Export
    @Override
    public MessageType getMessageType() {
        return super.getMessageType();
    }

    @HostAccess.Export
    @Override
    public long getAnonymousId() {
        return super.getAnonymousId();
    }

    @HostAccess.Export
    @Override
    public long getSelfId() {
        return super.getSelfId();
    }

    @HostAccess.Export
    @Override
    public long getSenderId() {
        return super.getSenderId();
    }

    @HostAccess.Export
    @Override
    public @Nullable String getAnonymousName() {
        return super.getAnonymousName();
    }

    @HostAccess.Export
    @Override
    public long getTime() {
        return super.getTime();
    }

    @HostAccess.Export
    @Override
    public String getRawMessage() {
        return super.getRawMessage();
    }
}
