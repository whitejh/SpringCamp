package com.sparta.springresttemplateclient.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

@Getter
@NoArgsConstructor
public class ItemDto {
    private String title;
    private int price;

    // JSONObject에서 ItemDto로 변환하기
   //  ItemDto에 받아온 JSONObject를 사용하여 초기화하는 생성자를 추가
    public ItemDto(JSONObject itemJson) {
        this.title = itemJson.getString("title");
        this.price = itemJson.getInt("price");
    }
}