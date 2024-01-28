const convert = require("google-translate-api");

export function translate(value) {
  convert(value, { to: "en" })
    .then((res) => {
      return res.text;
    })
    .catch((err) => {
      console.error(err);
    });
}
