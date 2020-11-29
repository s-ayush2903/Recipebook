# Recipebook
Get Recipes and cook yummy food 🎊 😋

If interested, join the discussion at [#recipebook](https://discord.gg/F5euNCUE7z) channel.


### CI (for dev)
|GitLab|Travis|
|---------------|----------------|
|[![pipeline status](https://gitlab.com/s-ayush2903/Recipebook/badges/dev/pipeline.svg)](https://gitlab.com/s-ayush2903/Recipebook/-/commits/dev)|[![Build Status](https://travis-ci.com/s-ayush2903/Recipebook.svg?branch=dev)](https://travis-ci.com/s-ayush2903/Recipebook)| 

Base Url being used for queries: 
~[Food2Fork.com](http://food2fork.com)~ ->  [RecipesApi](http://recipesapi.herokuapp.com/)

An native-android based client where we'll be pushing us to make it close to any food deliv. application. From the backend we have, we can search recipes and ingredients being used in them and how to cook them, the backend comprises of images etc.

So the module will be like this:
* We'll be having a single activity and multiple fragments attached to it.
* One screen will be showing the types of cuisines available.
* Clicking on the cuisine will lead to the related page and dishes.
* Clicking on the dish will lead us to the page that'll show us the recipe and the involved ingredients. 

Currently none of the screen is implemented and just makes a single API call to the backend. We'll be entirely following the Jetpack Components and Navigation to make the most out of it obviously with kotlin, coroutines and will try to use kotlin flows(to generate faster searches)

A work in progress.
Docs will be updated after some work has been done
