/**
 * INSPINIA - Responsive Admin Theme
 *
 */
var inspiniaApp = angular.module('inspinia', [
        'ui.router',                    // Routing
        'oc.lazyLoad',                  // ocLazyLoad
        'ui.bootstrap',                 // Ui Bootstrap
        'pascalprecht.translate',       // Angular Translate
        'ngIdle',                       // Idle timer
        'ngSanitize',                   // ngSanitize
        'http-auth-interceptor',
        'angular-spinkit',
        'ui.utils.masks'
    ]);

// Other libraries are loaded dynamically in the config.js file using the library ocLazyLoad