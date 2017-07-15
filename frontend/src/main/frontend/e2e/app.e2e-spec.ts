import { UkpPage } from './app.po';

describe('ukp App', function() {
  let page: UkpPage;

  beforeEach(() => {
    page = new UkpPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('up works!');
  });
});
