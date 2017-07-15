import { browser, element, by } from 'protractor';

export class UkpPage {
  navigateTo() {
    return browser.get('/');
  }

  getParagraphText() {
    return element(by.css('up-root h1')).getText();
  }
}
