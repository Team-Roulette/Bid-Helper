package com.roulette.bidhelper.ui.bidinfo

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.roulette.bidhelper.R
import com.roulette.bidhelper.models.apis.etc.BidBaseInfoListDTO
import com.roulette.bidhelper.ui.bidinfo.viewmodels.IndustryCodeSearchViewModel
import com.roulette.bidhelper.ui.bidinfo.viewmodels.IndustryDataState

@Composable
fun IndustrySearchScreen(
    modifier: Modifier = Modifier,
    viewModel: IndustryCodeSearchViewModel = viewModel(),
    onClick: (Map<Int, String>) -> Unit
) {
    Column(
        modifier = modifier.fillMaxSize()
    ){
        IndustrySpacerView()
        CategoryCodeSearchView(
            title = R.string.industry_category_code,
            content = viewModel.industryUiState.industryClassificationCode,
            changeUiState = {
                viewModel.updateUiState(
                    industryClassificationCode = it
                )
            }
        )

        IndustrySpacerView()
        NameSearchView(
            title = R.string.industry_name,
            content = viewModel.industryUiState.industryName,
            changeUiState = {
                viewModel.updateUiState(
                    industryName = it
                )
            }
        )

        IndustrySpacerView()
        CodeSearchView(
            title = R.string.industry_code,
            content = viewModel.industryUiState.industryCode,
            changeUiState = {
                viewModel.updateUiState(
                    industryCode = it
                )
            },
            onClick = {
                viewModel.searchIndustry()
            }
        )

        IndustrySpacerView()
        when(val uiState = viewModel.industryDataState) {
            is IndustryDataState.Success -> {
                CodeListView(
                    itemList = uiState.items,
                    viewModel = viewModel,
                    onClick = onClick
                )
            }
            is IndustryDataState.Loading -> {}
            is IndustryDataState.Error -> {}
        }

    }
}

@Composable
private fun CategoryCodeSearchView(
    @StringRes
    title: Int,
    content:String,
    changeUiState: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.fillMaxWidth(0.3f)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .height(40.dp)
                .border(1.dp, Color.LightGray)
        ) {
            BasicTextField(
                value = content,
                textStyle = MaterialTheme.typography.labelSmall,
                onValueChange = {
                    changeUiState(it)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            )
        }

        Text(
            text = "(2자리)",
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier
                .wrapContentWidth()
                .padding(start = 10.dp)
        )
    }
}



@Composable
private fun NameSearchView(
    @StringRes
    title: Int,
    content:String,
    changeUiState: (String) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.fillMaxWidth(0.3f)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp)
                .border(1.dp, Color.LightGray)
        ) {
            BasicTextField(
                value = content,
                textStyle = MaterialTheme.typography.labelSmall,
                onValueChange = {
                    changeUiState(it)
                },
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            )
        }
    }
}

@Composable
private fun CodeSearchView(
    @StringRes
    title: Int,
    content:String,
    changeUiState: (String) -> Unit,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = modifier
            .fillMaxWidth()
            .padding(vertical = 10.dp, horizontal = 20.dp)
    ) {
        Text(
            text = stringResource(title),
            style = MaterialTheme.typography.labelMedium,
            modifier = Modifier.fillMaxWidth(0.3f)
        )

        Box(
            modifier = Modifier
                .fillMaxWidth(0.3f)
                .height(40.dp)
                .border(1.dp, Color.LightGray)
        ) {
            BasicTextField(
                value = content,
                textStyle = MaterialTheme.typography.labelSmall,
                onValueChange = {
                    changeUiState(it)
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            )
        }

        Button(
            onClick = onClick,
            contentPadding = PaddingValues(0.dp),
            colors = ButtonDefaults.buttonColors(
                contentColor = Color.Black,
                containerColor = Color.LightGray
            ),
            shape = RoundedCornerShape(0.dp),
            modifier = Modifier
                .padding(start = 10.dp)
                .size(width = 40.dp, height = 30.dp)
        ) {
            Text(text = "검색")
        }
    }
}

@Composable
private fun CodeListView(
    modifier: Modifier = Modifier,
    onClick: (Map<Int, String>) -> Unit,
    viewModel: IndustryCodeSearchViewModel,
    itemList: List<BidBaseInfoListDTO.Response.Body.Item>?,
) {
    LazyColumn() {
        if(itemList != null) {
            items(itemList) {
                CodeListItem(
                    modifier = Modifier.fillMaxWidth(),
                    itemMap = viewModel.getItemAsMap(it),
                    onClick = onClick
                )
            }
        }
    }
}

@Composable
private fun CodeListItem(
    modifier: Modifier = Modifier,
    onClick: (Map<Int, String>) -> Unit = {},
    itemMap: Map<Int, String>,
    title: List<Int> = listOf(
        R.string.industry_search_category_code,
        R.string.industry_search_category_name,
        R.string.industry_search_code,
        R.string.industry_search_industry_name,
        R.string.industry_search_related_law,
        R.string.industry_search_related_rule,
    )
) {
    Column(
        modifier = Modifier.padding(20.dp)
            .clickable(enabled = true) {
                onClick(itemMap)
            }
    ){
        for(i in title.indices){
            Row {
                Text(
                    text = stringResource(id = title[i]),
                    modifier = Modifier.fillMaxWidth(0.3f)
                )

                itemMap[title[i]]?.let {
                    Text(
                        text = it,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }

}

@Composable
private fun IndustrySpacerView(
    modifier: Modifier = Modifier
) {
    Spacer(
        modifier = modifier
            .fillMaxWidth()
            .height(1.dp)
            .background(Color.LightGray)
    )
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun IndustryScreenPreview() {
    Surface {
        IndustrySearchScreen(
            onClick = {}
        )
    }
}