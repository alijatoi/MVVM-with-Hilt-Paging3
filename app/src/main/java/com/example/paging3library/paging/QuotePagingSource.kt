package com.example.paging3library.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.paging3library.QuoteList
import com.example.paging3library.Results
import com.example.paging3library.retrofit.QuoteAPI
import retrofit2.HttpException
import java.io.IOException

class QuotePagingSource (val quoteApi : QuoteAPI): PagingSource<Int, Results>() {


    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Results> {
        return try{
            val position = params.key ?:1
            val response = quoteApi.getQuotes(position)
            LoadResult.Page(
                data = response.results,
                prevKey = if(position ==1) null else position - 1,
                nextKey = if (position == response.totalPages) null else position + 1
            )
        }
        catch (e: IOException) {
            LoadResult.Error(e)
        } catch (e: HttpException) {
            LoadResult.Error(e)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Results>): Int? {
        return state.anchorPosition?.let {
            state.closestPageToPosition(it)?.prevKey?.plus(1)
                ?: state.closestPageToPosition(it)?.nextKey?.minus(1)
        }

    }
}