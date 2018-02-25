package com.cjs.qa.serenity.jbehave.steps.serenity;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

import com.cjs.qa.serenity.jbehave.pages.DictionaryPage;

import net.thucydides.core.annotations.Step;

public class EndUserSteps
{
	DictionaryPage dictionaryPage;

	@Step
	public void enters(String keyword)
	{
		dictionaryPage.enter_keywords(keyword);
	}

	@Step
	public void starts_search()
	{
		dictionaryPage.lookup_terms();
	}

	@Step
	public void should_see_definition(String definition)
	{
		assertThat(dictionaryPage.getDefinitions(), hasItem(containsString(definition)));
	}

	@Step
	public void is_the_home_page()
	{
		dictionaryPage.open();
		dictionaryPage.getDriver().manage().window().maximize();
	}

	@Step
	public void looks_for(String term)
	{
		enters(term);
		starts_search();
	}
}