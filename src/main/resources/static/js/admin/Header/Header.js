document.addEventListener('DOMContentLoaded', function () {
    const popoverTriggerList = document.querySelectorAll('[data-bs-toggle="popover"]');
    const popoverList = [...popoverTriggerList].map(popoverTriggerEl => new bootstrap.Popover(popoverTriggerEl));
    const dropdownTriggerList = document.querySelectorAll('[data-bs-toggle="dropdown"]');
    const dropdownList = [...dropdownTriggerList].map(dropdownTriggerEl => new bootstrap.Dropdown(dropdownTriggerEl));

    // When a dropdown opens, close any open popovers.
    dropdownList.forEach(dropdown => {
        dropdown._element.addEventListener('shown.bs.dropdown', () => {
            popoverList.forEach(popover => {
                popover.hide();
            });
        });
    });

    // When a popover opens, close any open dropdowns.
    popoverList.forEach(popover => {
        popover._element.addEventListener('shown.bs.popover', () => {
            dropdownList.forEach(dropdown => {
                dropdown.hide();
            });
        });
    });

    // Close popovers when you click somewhere else on the page
    document.body.addEventListener('click', function (event) {
        let clickedInsidePopover = false;

        popoverList.forEach(function (popover) {
            if (popover._element.contains(event.target)) {
                clickedInsidePopover = true;
            }
        });

        if (!clickedInsidePopover) {
            popoverList.forEach(function (popover) {
                popover.hide();
            });
        }
    }, true);
});