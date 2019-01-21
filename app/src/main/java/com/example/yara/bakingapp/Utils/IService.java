package com.example.yara.bakingapp.Utils;

import com.example.yara.bakingapp.Data.Response;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Yara on 16-Jan-19.
 */

public interface IService {
    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<List<Response>> getRecipes();
}
