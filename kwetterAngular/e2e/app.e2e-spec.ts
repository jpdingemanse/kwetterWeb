import { RekeningAdministratieAngularPage } from './app.po';

describe('rekening-administratie-angular App', function() {
  let page: RekeningAdministratieAngularPage;

  beforeEach(() => {
    page = new RekeningAdministratieAngularPage();
  });

  it('should display message saying app works', () => {
    page.navigateTo();
    expect(page.getParagraphText()).toEqual('app works!');
  });
});
