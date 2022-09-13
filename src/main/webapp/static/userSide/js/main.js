$(function () {

    "use strict";

    //===== Prealoder

    $(window).on('load', function (event) {
        $('#preloader').delay(500).fadeOut(500);
    });


    //===== Sticky

    $(window).on('scroll', function (event) {
        var scroll = $(window).scrollTop();
        if (scroll < 190) {
            $(".navigation").removeClass("sticky");
        } else {
            $(".navigation").addClass("sticky");
        }
    });


    //===== Mobile Menu 

    $(".navbar-toggler").on('click', function () {
        $(this).toggleClass('active');
    });

    $(".navbar-nav a").on('click', function () {
        $(".navbar-toggler").removeClass('active');
    });
    var subMenu = $(".sub-menu-bar .navbar-nav .sub-menu");

    if (subMenu.length) {
        subMenu.parent('li').children('a').append(function () {
            return '<button class="sub-nav-toggler"> <i class="fal fa-angle-down"></i> </button>';
        });

        var subMenuToggler = $(".sub-menu-bar .navbar-nav .sub-nav-toggler");

        subMenuToggler.on('click', function () {
            $(this).parent().parent().children(".sub-menu").slideToggle();
            return false
        });

    }




    //===== seller Active slick slider

    $('.courses-active').slick({
        dots: false,
        infinite: true,
        autoplay: true,
        autoplaySpeed: 5000,
        arrows: true,
        prevArrow: '<span class="prev"><i class="fal fa-arrow-left"></i></span>',
        nextArrow: '<span class="next"><i class="fal fa-arrow-right"></i></span>',
        speed: 1500,
        slidesToShow: 3,
        slidesToScroll: 1,
        responsive: [
            {
                breakpoint: 1201,
                settings: {
                    slidesToShow: 3,
                }
        },
            {
                breakpoint: 992,
                settings: {
                    slidesToShow: 2,
                }
        },
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 1,
                    arrows: false,
                }
        },
            {
                breakpoint: 576,
                settings: {
                    slidesToShow: 1,
                    arrows: false,
                }
        }
      ]
    });




    //===== seller Active slick slider

    $('.testimonials-active').slick({
        dots: false,
        infinite: true,
        autoplay: true,
        autoplaySpeed: 5000,
        arrows: true,
        prevArrow: '<span class="prev"><i class="fal fa-arrow-left"></i></span>',
        nextArrow: '<span class="next"><i class="fal fa-arrow-right"></i></span>',
        speed: 1500,
        slidesToShow: 1,
        slidesToScroll: 1,
        responsive: [
            {
                breakpoint: 992,
                settings: {
                    arrows: false,
                }
        }
      ]
    });


    //===== seller Active slick slider

    $('.testimonials-2-active').slick({
        dots: true,
        infinite: true,
        autoplay: true,
        autoplaySpeed: 5000,
        arrows: false,
        speed: 1500,
        slidesToShow: 3,
        slidesToScroll: 1,
        responsive: [
            {
                breakpoint: 1201,
                settings: {
                    slidesToShow: 3,
                }
        },
            {
                breakpoint: 992,
                settings: {
                    slidesToShow: 2,
                }
        },
            {
                breakpoint: 768,
                settings: {
                    slidesToShow: 1,
                    arrows: false,
                }
        },
            {
                breakpoint: 576,
                settings: {
                    slidesToShow: 1,
                    arrows: false,
                }
        }
      ]
    });




    //===== seller Active slick slider

    $('.course-learner-slide').slick({
        dots: true,
        infinite: true,
        autoplay: true,
        autoplaySpeed: 5000,
        arrows: false,
        speed: 1500,
        slidesToShow: 1,
        slidesToScroll: 1,
    });


    //===== Isotope Project 1

    $('.container').imagesLoaded(function () {
        var $grid = $('.grid').isotope({
            // options
            transitionDuration: '1s'
        });

        // filter items on button click
        $('.project-menu ul').on('click', 'li', function () {
            var filterValue = $(this).attr('data-filter');
            $grid.isotope({
                filter: filterValue
            });
        });

        //for menu active class
        $('.project-menu ul li').on('click', function (event) {
            $(this).siblings('.active').removeClass('active');
            $(this).addClass('active');
            event.preventDefault();
        });
    });


    //===== Projects Slide

    $('.brand-active').owlCarousel({
        loop: true,
        items: 5,
        dots: false,
        autoplay: true,
        autoplayTimeout: 5000,
        smartSpeed: 2000,
        nav: false,
        responsive: {
            0: {
                items: 2
            },
            768: {
                items: 3
            },
            992: {
                items: 4
            },
            1200: {
                items: 5
            },
            1600: {
                items: 5
            }
        }
    })



    //====== Magnific Popup

    $('.video-popup').magnificPopup({
        type: 'iframe',
        mainClass: 'mfp-fade',
        preloader: true
    });


    //===== Magnific Popup

    $('.image-popup').magnificPopup({
        type: 'image',
        gallery: {
            enabled: true
        }
    });





    //===== counter up
    $('.counter').counterUp({
        delay: 10,
        time: 2000
    });





    //===== Back to top

    // Show or hide the sticky footer button
    $(window).on('scroll', function (event) {
        if ($(this).scrollTop() > 600) {
            $('.back-to-top').fadeIn(200)
        } else {
            $('.back-to-top').fadeOut(200)
        }
    });


    //Animate the scroll to yop
    $('.back-to-top').on('click', function (event) {
        event.preventDefault();

        $('html, body').animate({
            scrollTop: 0,
        }, 1500);
    });




    //===== niceSelect js

    $('select').niceSelect();






    //===== coundown
    if ($("#days").length > 0) {
        const second = 1000,
            minute = second * 60,
            hour = minute * 60,
            day = hour * 24;
        let countDown = new Date('Sep 30, 2021 00:00:00').getTime(),
            x = setInterval(function () {
                let now = new Date().getTime(),
                    distance = countDown - now;
                document.getElementById('days').innerText = Math.floor(distance / (day)),
                    document.getElementById('hours').innerText = Math.floor((distance % (day)) / (hour)),
                    document.getElementById('minutes').innerText = Math.floor((distance % (hour)) / (minute)),
                    document.getElementById('seconds').innerText = Math.floor((distance % (minute)) / second);
            }, second);
    }

});
