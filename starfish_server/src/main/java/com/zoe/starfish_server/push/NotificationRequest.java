package com.zoe.starfish_server.push;

import java.io.Serializable;
import java.util.Map;

public class NotificationRequest implements Serializable {

    public static NotificationRequest buildMessage(String deviceToken, Map<String, String> customMap) {
        return build("message", deviceToken, null, null, customMap);
    }

    public static NotificationRequest buildNotification(String deviceToken, Map<String, String> paramMap, Map<String, String> extraMap) {
        return build("notification", deviceToken, paramMap, extraMap, paramMap.get("custom"));
    }

    private static NotificationRequest build(String displayType, String deviceToken, Map<String, String> paramMap, Map<String, String> extraMap, Object customMap) {
        NotificationRequest request = new NotificationRequest();
        request.setAppkey(PushConfig.APPKey);
        // 必填，时间戳，10位或者13位均可，时间戳有效期为10分钟
        request.setTimestamp(System.currentTimeMillis() + "");
        // 必填，消息发送类型,其值可以为:
        // unicast-单播
        // listcast-列播，要求不超过500个device_token
        // filecast-文件播，多个device_token可通过文件形式批量发送
        // broadcast-广播
        // groupcast-组播，按照filter筛选用户群,请参照filter参数
        // customizedcast，通过alias进行推送，包括以下两种case:
        // -alias:对单个或者多个alias进行推送
        // -file_id:将alias存放到文件后，根据file_id来推送
        request.setType("unicast");
        request.setDevice_tokens(deviceToken);
        NotificationRequest.Payload payload = new Payload();
        // 必填，消息类型: notification(通知)、message(消息)
        payload.setDisplay_type(displayType);
        NotificationRequest.Body body = new Body();

        if (paramMap != null) {
            // 必填，通知标题
            body.setTitle(paramMap.get("title"));
            // 必填，通知文字描述
            body.setText(paramMap.get("text"));
            //可选, 通知栏提示文字
            body.setTicker(paramMap.get("ticker"));
            //可选, 最多120个字符大文本
            body.setBig_body(paramMap.get("big_body"));
            // 自定义通知图标:// 可选，状态栏图标ID，R.drawable.[smallIcon]，
            // 如果没有，默认使用应用图标 图片要求为24*24dp的图标，或24*24px放在drawable-mdpi下
            // 注意四周各留1个dp的空白像素
            body.setIcon(paramMap.get("icon"));
            // 可选，通知栏大图标的URL链接。 该字段要求以http或者https开头，图片建议不大于100KB。
            body.setImg(paramMap.get("img"));
            // 自定义通知声音:
            body.setSound(paramMap.get("sound"));
            // 当after_open=go_url时，必填  通知栏点击后跳转的URL，要求以http或者https开头
            body.setUrl(paramMap.get("url"));
            //当after_open=go_activity时，必填。 通知栏点击后打开的Activity
            body.setActivity(paramMap.get("activity"));
        }

        // 当display_type=message时,必填
        // 当display_type=notification且after_open=go_custom时，必填
        // 用户自定义内容，可以为字符串或者JSON格式。
        body.setCustom(customMap);
        //可选，JSON格式，用户自定义key-value。
        payload.setExtra(extraMap);
        payload.setBody(body);
        request.setPayload(payload);
        return request;
    }

    private String appkey;
    private String timestamp;

    // 必填，消息发送类型,其值可以为:
    // unicast-单播
    // listcast-列播，要求不超过500个device_token
    // filecast-文件播，多个device_token可通过文件形式批量发送
    // broadcast-广播
    // groupcast-组播，按照filter筛选用户群,请参照filter参数
    // customizedcast，通过alias进行推送，包括以下两种case:
    // -alias:对单个或者多个alias进行推送
    // -file_id:将alias存放到文件后，根据file_id来推送
    private String type;
    private String device_tokens;
    private String alias_type;
    private String alias;
    private String file_id;
    private Map<String, Object> filter;
    private String group_id;
    private Payload payload;
    private Policy policy;
    private boolean production_mode;
    private String description;
    private ChannelProperties channel_properties;
    private LocalProperties local_properties;

    // Getters and Setters

    public static class Payload {
        private String display_type;
        private Body body;
        private Map<String, String> extra;

        // Getters and Setters

        @Override
        public String toString() {
            return "Payload{" +
                    "display_type='" + display_type + '\'' +
                    ", body=" + body +
                    ", extra=" + extra +
                    '}';
        }

        public String getDisplay_type() {
            return display_type;
        }

        public void setDisplay_type(String display_type) {
            this.display_type = display_type;
        }

        public Body getBody() {
            return body;
        }

        public void setBody(Body body) {
            this.body = body;
        }

        public Map<String, String> getExtra() {
            return extra;
        }

        public void setExtra(Map<String, String> extra) {
            this.extra = extra;
        }
    }

    public static class Body {
        private String title;
        private String text;
        private String ticker;
        private String big_body;
//        private int re_pop;
        private String icon;
        private String img;
        private String expand_image;
        private String sound;
        private int builder_id;
        private int set_badge;
        private int add_badge;
        private boolean play_vibrate;
        private boolean play_lights;
        private boolean play_sound;
        private String after_open;
        private String url;
        private String activity;
        private Object custom;

        // Getters and Setters

        @Override
        public String toString() {
            return "Body{" +
                    "title='" + title + '\'' +
                    ", text='" + text + '\'' +
                    ", ticker='" + ticker + '\'' +
                    ", big_body='" + big_body + '\'' +
                    ", icon='" + icon + '\'' +
                    ", img='" + img + '\'' +
                    ", expand_image='" + expand_image + '\'' +
                    ", sound='" + sound + '\'' +
                    ", builder_id=" + builder_id +
                    ", set_badge=" + set_badge +
                    ", add_badge=" + add_badge +
                    ", play_vibrate=" + play_vibrate +
                    ", play_lights=" + play_lights +
                    ", play_sound=" + play_sound +
                    ", after_open='" + after_open + '\'' +
                    ", url='" + url + '\'' +
                    ", activity='" + activity + '\'' +
                    ", custom=" + custom +
                    '}';
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public String getTicker() {
            return ticker;
        }

        public void setTicker(String ticker) {
            this.ticker = ticker;
        }

        public String getBig_body() {
            return big_body;
        }

        public void setBig_body(String big_body) {
            this.big_body = big_body;
        }

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public String getImg() {
            return img;
        }

        public void setImg(String img) {
            this.img = img;
        }

        public String getExpand_image() {
            return expand_image;
        }

        public void setExpand_image(String expand_image) {
            this.expand_image = expand_image;
        }

        public String getSound() {
            return sound;
        }

        public void setSound(String sound) {
            this.sound = sound;
        }

        public int getBuilder_id() {
            return builder_id;
        }

        public void setBuilder_id(int builder_id) {
            this.builder_id = builder_id;
        }

        public int getSet_badge() {
            return set_badge;
        }

        public void setSet_badge(int set_badge) {
            this.set_badge = set_badge;
        }

        public int getAdd_badge() {
            return add_badge;
        }

        public void setAdd_badge(int add_badge) {
            this.add_badge = add_badge;
        }

        public boolean isPlay_vibrate() {
            return play_vibrate;
        }

        public void setPlay_vibrate(boolean play_vibrate) {
            this.play_vibrate = play_vibrate;
        }

        public boolean isPlay_lights() {
            return play_lights;
        }

        public void setPlay_lights(boolean play_lights) {
            this.play_lights = play_lights;
        }

        public boolean isPlay_sound() {
            return play_sound;
        }

        public void setPlay_sound(boolean play_sound) {
            this.play_sound = play_sound;
        }

        public String getAfter_open() {
            return after_open;
        }

        public void setAfter_open(String after_open) {
            this.after_open = after_open;
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getActivity() {
            return activity;
        }

        public void setActivity(String activity) {
            this.activity = activity;
        }

        public Object getCustom() {
            return custom;
        }

        public void setCustom(Object custom) {
            this.custom = custom;
        }
    }

    public static class Policy {
        private String start_time;
        private String expire_time;
        private int max_send_num;
        private String out_biz_no;
        private boolean notification_closed_filter;
        private InApp in_app;

        // Getters and Setters


        @Override
        public String toString() {
            return "Policy{" +
                    "start_time='" + start_time + '\'' +
                    ", expire_time='" + expire_time + '\'' +
                    ", max_send_num=" + max_send_num +
                    ", out_biz_no='" + out_biz_no + '\'' +
                    ", notification_closed_filter=" + notification_closed_filter +
                    ", in_app=" + in_app +
                    '}';
        }

        public String getStart_time() {
            return start_time;
        }

        public void setStart_time(String start_time) {
            this.start_time = start_time;
        }

        public String getExpire_time() {
            return expire_time;
        }

        public void setExpire_time(String expire_time) {
            this.expire_time = expire_time;
        }

        public int getMax_send_num() {
            return max_send_num;
        }

        public void setMax_send_num(int max_send_num) {
            this.max_send_num = max_send_num;
        }

        public String getOut_biz_no() {
            return out_biz_no;
        }

        public void setOut_biz_no(String out_biz_no) {
            this.out_biz_no = out_biz_no;
        }

        public boolean isNotification_closed_filter() {
            return notification_closed_filter;
        }

        public void setNotification_closed_filter(boolean notification_closed_filter) {
            this.notification_closed_filter = notification_closed_filter;
        }

        public InApp getIn_app() {
            return in_app;
        }

        public void setIn_app(InApp in_app) {
            this.in_app = in_app;
        }
    }

    public static class InApp {
        private boolean in_app;

        // Getters and Setters

        @Override
        public String toString() {
            return "InApp{" +
                    "in_app=" + in_app +
                    '}';
        }

        public boolean isIn_app() {
            return in_app;
        }

        public void setIn_app(boolean in_app) {
            this.in_app = in_app;
        }
    }

    public static class ChannelProperties {
        private String channel_activity;
        private String xiaomi_channel_id;
        private String vivo_category;
        private String oppo_channel_id;
        private String main_activity;
        private String huawei_channel_importance;
        private String huawei_channel_category;
        private String channel_fcm;

        // Getters and Setters


        @Override
        public String toString() {
            return "ChannelProperties{" +
                    "channel_activity='" + channel_activity + '\'' +
                    ", xiaomi_channel_id='" + xiaomi_channel_id + '\'' +
                    ", vivo_category='" + vivo_category + '\'' +
                    ", oppo_channel_id='" + oppo_channel_id + '\'' +
                    ", main_activity='" + main_activity + '\'' +
                    ", huawei_channel_importance='" + huawei_channel_importance + '\'' +
                    ", huawei_channel_category='" + huawei_channel_category + '\'' +
                    ", channel_fcm='" + channel_fcm + '\'' +
                    '}';
        }

        public String getChannel_activity() {
            return channel_activity;
        }

        public void setChannel_activity(String channel_activity) {
            this.channel_activity = channel_activity;
        }

        public String getXiaomi_channel_id() {
            return xiaomi_channel_id;
        }

        public void setXiaomi_channel_id(String xiaomi_channel_id) {
            this.xiaomi_channel_id = xiaomi_channel_id;
        }

        public String getVivo_category() {
            return vivo_category;
        }

        public void setVivo_category(String vivo_category) {
            this.vivo_category = vivo_category;
        }

        public String getOppo_channel_id() {
            return oppo_channel_id;
        }

        public void setOppo_channel_id(String oppo_channel_id) {
            this.oppo_channel_id = oppo_channel_id;
        }

        public String getMain_activity() {
            return main_activity;
        }

        public void setMain_activity(String main_activity) {
            this.main_activity = main_activity;
        }

        public String getHuawei_channel_importance() {
            return huawei_channel_importance;
        }

        public void setHuawei_channel_importance(String huawei_channel_importance) {
            this.huawei_channel_importance = huawei_channel_importance;
        }

        public String getHuawei_channel_category() {
            return huawei_channel_category;
        }

        public void setHuawei_channel_category(String huawei_channel_category) {
            this.huawei_channel_category = huawei_channel_category;
        }

        public String getChannel_fcm() {
            return channel_fcm;
        }

        public void setChannel_fcm(String channel_fcm) {
            this.channel_fcm = channel_fcm;
        }
    }

    public static class LocalProperties {
        private String category;
        private String importance;

        // Getters and Setters


        @Override
        public String toString() {
            return "LocalProperties{" +
                    "category='" + category + '\'' +
                    ", importance='" + importance + '\'' +
                    '}';
        }

        public String getCategory() {
            return category;
        }

        public void setCategory(String category) {
            this.category = category;
        }

        public String getImportance() {
            return importance;
        }

        public void setImportance(String importance) {
            this.importance = importance;
        }
    }

    // Getters and Setters for NotificationRequest

    @Override
    public String toString() {
        return "NotificationRequest{" +
                "appkey='" + appkey + '\'' +
                ", timestamp='" + timestamp + '\'' +
                ", type='" + type + '\'' +
                ", device_tokens='" + device_tokens + '\'' +
                ", alias_type='" + alias_type + '\'' +
                ", alias='" + alias + '\'' +
                ", file_id='" + file_id + '\'' +
                ", filter=" + filter +
                ", group_id='" + group_id + '\'' +
                ", payload=" + payload +
                ", policy=" + policy +
                ", production_mode=" + production_mode +
                ", description='" + description + '\'' +
                ", channel_properties=" + channel_properties +
                ", local_properties=" + local_properties +
                '}';
    }

    public String getAppkey() {
        return appkey;
    }

    public void setAppkey(String appkey) {
        this.appkey = appkey;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDevice_tokens() {
        return device_tokens;
    }

    public void setDevice_tokens(String device_tokens) {
        this.device_tokens = device_tokens;
    }

    public String getAlias_type() {
        return alias_type;
    }

    public void setAlias_type(String alias_type) {
        this.alias_type = alias_type;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public Map<String, Object> getFilter() {
        return filter;
    }

    public void setFilter(Map<String, Object> filter) {
        this.filter = filter;
    }

    public String getGroup_id() {
        return group_id;
    }

    public void setGroup_id(String group_id) {
        this.group_id = group_id;
    }

    public Payload getPayload() {
        return payload;
    }

    public void setPayload(Payload payload) {
        this.payload = payload;
    }

    public Policy getPolicy() {
        return policy;
    }

    public void setPolicy(Policy policy) {
        this.policy = policy;
    }

    public boolean isProduction_mode() {
        return production_mode;
    }

    public void setProduction_mode(boolean production_mode) {
        this.production_mode = production_mode;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ChannelProperties getChannel_properties() {
        return channel_properties;
    }

    public void setChannel_properties(ChannelProperties channel_properties) {
        this.channel_properties = channel_properties;
    }

    public LocalProperties getLocal_properties() {
        return local_properties;
    }

    public void setLocal_properties(LocalProperties local_properties) {
        this.local_properties = local_properties;
    }
}

