package demo.api.token;

public class TokenConfig{

    private interface ITokenConfig {
        String getSecureKey();

        long getTokenExpireTime();

        long getRefreshTokenExpireTime();
    }

    private class Release implements ITokenConfig {
        private String SECURE_KEY = "asdadsdsdsadsa-adsadsadsaddas-dsadas-dadasa";
        /**
         * Token expired in 1 day
         */
        private long TOKEN_EXPIRED_TIME = 24 * 60;
        /**
         * Refresh token expired in 30 day
         */
        private long TOKEN_REFRESH_EXPIRED_TIME = 30 * 24 * 60;

        @Override
        public String getSecureKey() {
            return SECURE_KEY;
        }

        @Override
        public long getTokenExpireTime() {
            return TOKEN_EXPIRED_TIME;
        }

        @Override
        public long getRefreshTokenExpireTime() {
            return TOKEN_REFRESH_EXPIRED_TIME;
        }
    }

    private static final class Debug implements ITokenConfig {
        private String SECURE_KEY = "asdadsdsdsadsa-adsadsadsaddas-dsadas-dadasa";
        /**
         * Token expired in 1 hour
         */
        private long TOKEN_EXPIRED_TIME = 60;
        /**
         * Refresh token expired in 30 day
         */
        private long TOKEN_REFRESH_EXPIRED_TIME = 30 * 24 * 60;

        @Override
        public String getSecureKey() {
            return SECURE_KEY;
        }

        @Override
        public long getTokenExpireTime() {
            return TOKEN_EXPIRED_TIME;
        }

        @Override
        public long getRefreshTokenExpireTime() {
            return TOKEN_REFRESH_EXPIRED_TIME;
        }
    }

    private static final ITokenConfig config = new Debug();


    public static String getSecureKey() {
        return config.getSecureKey();
    }

    public static long getTokenExpireTime() {
        return config.getTokenExpireTime();
    }

    public static long getRefreshTokenExpireTime() {
        return config.getRefreshTokenExpireTime();
    }
}
