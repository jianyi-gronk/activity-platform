const translate = require("translate");

translate.engine = "google";
translate.key = "YOUR_API_KEY";

const textToTranslate = "要翻译的文本";
const targetLanguage = "en";

translate(textToTranslate, targetLanguage)
  .then((translatedText) => {
    console.log(translatedText);
  })
  .catch((error) => {
    console.error(error);
  });
