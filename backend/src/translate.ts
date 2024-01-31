import translate from "translate";
import toxicity from '@tensorflow-models/toxicity'

const threshold = 0.9;
const model = await toxicity.load(threshold, []);

export async function checkText(text: string) {
	// 进行翻译
  text = await translate(text, { from: 'zh', to: 'en' });
	const sentences = [text];
	
	// 毒性检测
  const predictions = await model.classify(sentences)
  return predictions;
}
