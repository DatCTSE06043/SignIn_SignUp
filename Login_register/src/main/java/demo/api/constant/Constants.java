package demo.api.constant;

/**
 * Created by tuanle on 6/2/18.
 */
public class Constants {

    public final static String NAME_TIME_ZONE = "Japan";

    public static final String TITLE_MESSAGE_PREFIX="さんから新しいメッセージが来ました。";

    public static final String PUSH_IMAGE_SHORT_DESCRIPTION="画像がきました。";
    public static final String PUSH_VIDEO_SHORT_DESCRIPTION="動画がきました。";
    public static final String PUSH_STICKER_SHORT_DESCRIPTION="ステッカーがきました。";
    public static final String PUSH_AUDIO_SHORT_DESCRIPTION="音声がきました。";
    public static final String PUSH_LOCATION_SHORT_DESCRIPTION="位置の情報が来ました。";


    public static final String OLIOA_USER_PREFIX = "olioa_user_";
    public static final String OLIOA_GROUP_PREFIX = "olioa_group_";
    public static final String OLIOA_CHAT_MESSAGE_PREFIX = "olioa_chat_message_";

    public static final int APP_ID_OLIOA = 0;
    public static final int APP_ID_OBIS = 1;
    public static final int APP_ID_IUNGO = 2;
    public static final int APP_ID_RESALE_YARDS = 3;
    public static final int APP_ID_LISAR = 4;
    public static final int APP_ID_YUKI = 5;
    public static final int APP_ID_REACH = 6;




    public static final String EMPTY = "";

    public static final int LIMIT = 30;

    static class AppId {

        public static final int USER = 1;

        public static final int STORE = 2;
    }

    public static class UserType {

        public static final int USER = 1;

        public static final int STORE = 2;
    }
}
