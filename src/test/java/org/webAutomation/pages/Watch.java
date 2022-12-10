package org.webAutomation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class Watch extends Homepage{

    public Watch(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".BucketsContainer>div:first-child .Carousel__Inner>li:nth-child(2)")
    private WebElement secondElement;

    @FindBy(css = "button.lightbox__closebtn")
    private WebElement closePopupBtn;

    @FindBy(className = "lightbox__contentBox")
    private WebElement watchLightbox;

    @FindBy(className = "Carousel")
    private List<WebElement> carouselList;

    @FindBy(css = ".BucketsContainer>div:first-child .CarouselSlide")
    private List<WebElement> firstCarouselTiles;

    @FindBy(css = ".BucketsContainer>div:first-child .CarouselSlide .WatchTile__Title")
    private List<WebElement> tileTitles;

    @FindBy(css = ".BucketsContainer>div:first-child .CarouselSlide .WatchTile__Meta")
    private List<WebElement> tileMetas;

    public WebElement getSecondElement() {
        return secondElement;
    }

    public WebElement getClosePopupBtn() {
        return closePopupBtn;
    }

    public WebElement getWatchLightbox() {
        return watchLightbox;
    }

    public List<WebElement> getCarouselList() {
        return carouselList;
    }

    public List<WebElement> getFirstCarouselTiles() {
        return firstCarouselTiles;
    }

    public List<WebElement> getTileTitles() {
        return tileTitles;
    }

    public List<WebElement> getTileMetas() {
        return tileMetas;
    }

    public int countCarousels() {
        return getCarouselList().size();
    }

    public int countCarouselTiles() {
        return getFirstCarouselTiles().size();
    }

    public int countTitleTiles() {
        return getTileTitles().size();
    }

    public int countTitleMetas() {
        return getTileMetas().size();
    }

    public boolean isWatchPageDisplayed() {
        if ( countCarouselTiles() == countTitleTiles() ) {
            if ( countTitleTiles() == countTitleMetas() ) {
                return true;
            }
        }
        return false;
    }

    public boolean isLightboxDisplayed() { return getWatchLightbox().isDisplayed() && getClosePopupBtn().isDisplayed(); }

}
