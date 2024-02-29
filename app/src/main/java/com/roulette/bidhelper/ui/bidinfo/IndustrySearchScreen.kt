package com.roulette.bidhelper.ui.bidinfo

import androidx.annotation.StringRes
import androidx.compose.foundation.background
import androidx.compose.foundation.border
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.roulette.bidhelper.R

@Composable
fun IndustrySearchScreen(
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize()
    ){
        IndustrySpacerView()
        CategoryCodeSearchView(title = R.string.industry_category_code, content = "", changeUiState = {})

        IndustrySpacerView()
        NameSearchView(title = R.string.industry_name, content = "", changeUiState = {})

        IndustrySpacerView()
        CodeSearchView(title = R.string.industry_code, content = "", changeUiState = {})

        IndustrySpacerView()
        CodeListView()
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
                    imeAction = ImeAction.Done
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
                    imeAction = ImeAction.Done
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
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 10.dp)
            )
        }

        Button(
            onClick = {},
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
    itemList: List<String> = listOf("aaa", "bbb", "ccc"),
) {
    LazyColumn() {
        items(itemList) {
            CodeListItem(
                modifier = Modifier.fillMaxWidth(),
                item = it
            )
        }
    }
}

@Composable
private fun CodeListItem(
    modifier: Modifier = Modifier,
    item: String,
    title: List<Int> = listOf(
        R.string.industry_search_number,
        R.string.industry_search_category_code,
        R.string.industry_search_category_name,
        R.string.industry_search_code,
        R.string.industry_search_industry_name,
        R.string.industry_search_included_relation,
        R.string.industry_search_related_law,
        R.string.industry_search_related_rule,
    )
) {
    Column(
        modifier = Modifier.padding(20.dp)
    ){
        for(i in title.indices){
            Row {
                Text(
                    text = stringResource(id = title[i]),
                    modifier = Modifier.fillMaxWidth(0.3f)
                )

                Text(
                    text = item,
                    modifier = Modifier.fillMaxWidth()
                )
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
        IndustrySearchScreen()
    }
}