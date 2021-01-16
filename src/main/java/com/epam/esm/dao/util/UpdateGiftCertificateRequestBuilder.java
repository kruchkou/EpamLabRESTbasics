package com.epam.esm.dao.util;

import com.epam.esm.model.entity.GiftCertificate;
import com.epam.esm.model.util.UpdateGiftCertificateRequest;

import java.time.Instant;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;

public class UpdateGiftCertificateRequestBuilder {

    private final static UpdateGiftCertificateRequestBuilder instance = new UpdateGiftCertificateRequestBuilder();

    private final static StringBuilder sqlRequestBuilder = new StringBuilder();

    private final static Map<String, Object> paramMap = new LinkedHashMap<>();

    private final static String SPLIT_PARAM_STRING = ", ";
    private final static String UPDATE_SQL = "UPDATE gift_certificate SET ";
    private final static String ADD_NAME_SQL = "name = ?";
    private final static String ADD_DESCRIPTION = "description = ?";
    private final static String ADD_PRICE = "price = ?";
    private final static String ADD_DURATION = "duration = ?";
    private final static String FINAL_SQL = " WHERE id = ?";
    private final static String ADD_LAST_UPDATE_DATE = "last_update_date = ?";

    private UpdateGiftCertificateRequestBuilder() {
    }

    public static UpdateGiftCertificateRequestBuilder getInstance() {
        return instance;
    }

    public UpdateGiftCertificateRequest build(GiftCertificate giftCertificate) {
        String name = giftCertificate.getName();
        String description = giftCertificate.getDescription();
        Integer price = giftCertificate.getPrice();
        Integer duration = giftCertificate.getDuration();
        Instant lastUpdateInstant = giftCertificate.getLastsUpdateDate();

        if (!(name == null)) {
            setName(name);
        }
        if (!(description == null)) {
            setDescription(description);
        }
        if (!(price == null)) {
            setPrice(price);
        }
        if (!(duration == null)) {
            setDuration(duration);
        }
        if (!(lastUpdateInstant == null)) {
            setLastUpdateDate(lastUpdateInstant);
        }
        return build();
    }

    public UpdateGiftCertificateRequest build() {
        ArrayList<String> sqlParamList = new ArrayList<>();
        ArrayList<Object> valueParamList = new ArrayList<>();

        paramMap.forEach((key, value) -> {
            sqlParamList.add(key);
            valueParamList.add(value);
        });

        Object[] params = valueParamList.toArray();

        final String SQL_PARAM_QUERY = String.join(SPLIT_PARAM_STRING, sqlParamList);
        final String REQUEST_SQL = sqlRequestBuilder.append(UPDATE_SQL).append(SQL_PARAM_QUERY).append(FINAL_SQL).toString();

        UpdateGiftCertificateRequest updateGiftCertificateQuery = new UpdateGiftCertificateRequest(REQUEST_SQL, params);

        clear();
        return updateGiftCertificateQuery;
    }


    public UpdateGiftCertificateRequestBuilder setName(String name) {
        paramMap.put(ADD_NAME_SQL, name);
        return this;
    }

    public UpdateGiftCertificateRequestBuilder setLastUpdateDate(Instant lastUpdateDate) {
        paramMap.put(ADD_LAST_UPDATE_DATE, lastUpdateDate);
        return this;
    }

    public UpdateGiftCertificateRequestBuilder setDescription(String description) {
        paramMap.put(ADD_DESCRIPTION, description);
        return this;
    }

    public UpdateGiftCertificateRequestBuilder setPrice(int price) {
        paramMap.put(ADD_PRICE, price);
        return this;
    }

    public UpdateGiftCertificateRequestBuilder setDuration(int duration) {
        paramMap.put(ADD_DURATION, duration);
        return this;
    }

    private void clear() {
        sqlRequestBuilder.setLength(0);
        paramMap.clear();
    }

}